import React, { useEffect, useState } from "react";
import {
  Table,
  TableBody,
  TableCaption,
  TableCell,
  TableFooter,
  TableHead,
  TableHeader,
  TableRow,
} from "@/components/ui/table";
import { get } from "@/lib/http";

const invoices = [
  {
    stt: "1",
    maLHP: "420300233002",
    tenLHP: "Lập trình phân tích dữ liệu 2",
    lop: "DHKTPM16A",
    thuongKy1: "3",
    thuongKy2: "6",
    cuoiKi: "9",
  },
  {
    stt: "1",
    maLHP: "420300233002",
    tenLHP: "Lập trình phân tích dữ liệu 2",
    lop: "DHKTPM16A",
    thuongKy1: "3",
    thuongKy2: "6",
    cuoiKi: "9",
  },
  {
    stt: "1",
    maLHP: "420300233002",
    tenLHP: "Lập trình phân tích dữ liệu 2",
    lop: "DHKTPM16A",
    thuongKy1: "3",
    thuongKy2: "6",
    cuoiKi: "9",
  },
];
interface Grade{
  gradeId:number,
  courseDto:CourseDto,
  regular:number,
  mid:number,
  finalOfTerm:number,
  total:number
}

interface CourseDto{
  courseId: number,
  courseName: string,
  credits: number
}



export default function MarkClass() {
  const [grades,setGrades] = useState<Grade[]>();

  const id = 1;
  const sid = 1;
  useEffect(() => {
    const fetchCourses = async () => {
      try {
        const res = await get<Grade[]>("/api/v1/academy/grades/student/"+id);
        const data = res.data;
        setGrades(data)
      } catch (error) {
        console.error("Failed to fetch courses", error);
      }
    };
    fetchCourses();
  }, []);
  return (
    <div className="pb-6">
      <div className="flex text-3xl justify-center pb-4 border-b-2 pt-6">
        Điểm môn ....
      </div>
      <div className="w-auto h-auto pb-6 border-b-[16px]">
        <Table>
          <TableHeader>
            <TableRow>
              <TableHead className="text-center">STT</TableHead>
              <TableHead>Tên lớp học phần</TableHead>
              <TableHead className="text-center">Thường kỳ 1</TableHead>
              <TableHead className="text-center">Thường kỳ 2</TableHead>
              <TableHead className="text-center">Cuối kỳ </TableHead>
              <TableHead className="text-center">Tổng kết </TableHead>
              <TableHead className="text-center">Xuất loại </TableHead>
            </TableRow>
          </TableHeader>
          <TableBody>
            {grades?.map((grade) => (
              <TableRow key={grade.gradeId}>
                <TableCell className="text-center">{grades.indexOf(grade)+1}</TableCell>
                <TableCell>{grade.courseDto.courseName}</TableCell>
                <TableCell className="text-center">{grade.regular}</TableCell>
                <TableCell className="text-center">{grade.mid}</TableCell>
                <TableCell className="text-center">
                  {grade.finalOfTerm}
                </TableCell>
                <TableCell className="text-center">
                  {grade.total}
                </TableCell>
                <TableCell className="text-center">{grade.total>9?"Xuất sắc":grade.total<9?"Giỏi":grade.total<8?"Khá":grade.total<7?"Trung bình":grade.total<5?"Yếu":"Kém"}</TableCell>
              </TableRow>
            ))}
          </TableBody>
          <TableFooter></TableFooter>
        </Table>
      </div>
    </div>
  );
}
