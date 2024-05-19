"use client"
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
import DetailClassCredit from "@/components/DetailClassCredit";
import { Checkbox } from "./ui/checkbox";
import { get } from "@/lib/http";

const invoices = [
  {
    icon: true,
    stt: "1",
    maLHP: "420300233002",
    tenLHP: "Lập trình phân tích dữ liệu 2",
    lopDukien: "DHKTPM16A",
    siso: "80",
    daDangKy: "0",
  },
  {
    icon: true,
    stt: "1",
    maLHP: "420300233002",
    tenLHP: "Lập trình phân tích dữ liệu 2",
    lopDukien: "DHKTPM16A",
    siso: "80",
    daDangKy: "0",
  },
  {
    icon: true,
    stt: "1",
    maLHP: "420300233002",
    tenLHP: "Lập trình phân tích dữ liệu 2",
    lopDukien: "DHKTPM16A",
    siso: "80",
    daDangKy: "0",
  },
];

interface Classs{
  classId:number,
  courseId:number,
  enrollments:Enrollment[],
  instructor:string,
  maxStudents:number,
  roomId:number,
  scheduleId:number,
  semester:number
}

interface Enrollment{
  enrollmentId:number
}

interface Course{
  courseId:number,
  courseName:string,
  credits:number
}

interface ClassCreditProps {
  course?: Course;
}
export default function ClassCredit({ course }: ClassCreditProps) {
  const [classes,setClasses] = useState<Classs[]>([])
  const [selectedClass, setSelectedClass] = useState<Classs>();
  
  useEffect(() => {
    const fetchCourses = async () => {
      try {
        const res = await get("/api/v1/class/course_id/"+course?.courseId);
        const data = res.data;
        setClasses(data as Classs[]);
        console.log(data)
      } catch (error) {
        console.error("Failed to fetch courses", error);
      }
    };
    fetchCourses();
  }, [course]);
  return (
    <div className="pb-6">
      <div className="flex text-3xl justify-center pb-4 border-b-2 pt-6">
        Lớp học phần chờ đăng ký
      </div>
      <div className="w-auto h-auto pb-6 border-b-[16px]">
        <Table>
          <TableHeader>
            <TableRow>
              <TableHead>STT</TableHead>
              <TableHead>Mã LHP</TableHead>
              <TableHead>Tên lớp học phần</TableHead>
              <TableHead>Lớp dự kiến</TableHead>
              <TableHead>Sĩ số tối đa</TableHead>
              <TableHead>Đã đăng ký</TableHead>
            </TableRow>
          </TableHeader>
          <TableBody>
            {classes.map((clasz) => (
              <TableRow key={clasz.classId}
              onClick={()=>{
                if(clasz.enrollments.length>=clasz.maxStudents){
                  alert("Lớp đã đủ sinh viên")
                }
                else{
                setSelectedClass(clasz)
                }
              }}
              >
         
                <TableCell>{classes.indexOf(clasz)}</TableCell>
                <TableCell>{clasz.classId}</TableCell>
                <TableCell>{course?.courseName}</TableCell>
                <TableCell>{clasz.roomId}</TableCell>
                <TableCell>{clasz.maxStudents}</TableCell>
                <TableCell>{clasz.enrollments.length}</TableCell>
              </TableRow>
            ))}
          </TableBody>
          <TableFooter></TableFooter>
        </Table>
      </div>
      {selectedClass?<DetailClassCredit classs = {selectedClass}/>:""}
    </div>
  );
}
