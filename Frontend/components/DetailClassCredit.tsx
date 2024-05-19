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
import { Button } from "./ui/button";
import { get, post } from "@/lib/http";

const invoices = [
  {
    stt: "1",
    lichhoc: "LT - Thứ 2 (T13 -> T15)",
    nhomTH: "2",
    phong: "A2.05",
    giangvien: "Nguyễn Thị Đẹt",
    tgian: "25/12/2023 - 22/04/2024",
  },
  {
    stt: "1",
    lichhoc: "LT - Thứ 2 (T13 -> T15)",
    nhomTH: "2",
    phong: "A2.05",
    giangvien: "Nguyễn Thị Đẹt",
    tgian: "25/12/2023 - 22/04/2024",
  },
  {
    stt: "1",
    lichhoc: "LT - Thứ 2 (T13 -> T15)",
    nhomTH: "2",
    phong: "A2.05",
    giangvien: "Nguyễn Thị Đẹt",
    tgian: "25/12/2023 - 22/04/2024",
  },
];
interface Classs{
  classId:number,
  courseId:number,
  instructor:string,
  maxStudents:number,
  roomId:number,
  scheduleId:number,
  semester:number
}

interface Schedule{
  scheduleId:number,
  classId:number,
  dayOfWeek:string,
  time:string,
  group:number
}

interface ClassCreditProps {
  classs?: Classs;
}

export default function DetailClassCredit({ classs }: ClassCreditProps) {
  console.log(classs)
  const [schedules,setSchedules] = useState<Schedule[]>();
  useEffect(() => {
    const fetchCourses = async () => {
      try {
        const res = await get("api/v1/schedule/class_id/"+classs?.classId);
        const data = res.data;
        setSchedules(data as Schedule[])
        console.log(data)
      } catch (error) {
        console.error("Failed to fetch courses", error);
      }
    };
    fetchCourses();
  }, [classs]);
  return (
    <div className="pb-6">
      <div className="flex text-3xl justify-center pb-6">
        Chi tiết lớp học phần
      </div>
      <div className="w-auto h-auto pb-6 border-b-[16px]">
        <Table>
          <TableHeader>
            <TableRow>
              <TableHead>STT</TableHead>
              <TableHead>Lịch học</TableHead>
              <TableHead>Nhóm TH</TableHead>
              <TableHead>Phòng</TableHead>
              <TableHead>Giảng viên</TableHead>
              <TableHead>Thời gian</TableHead>
            </TableRow>
          </TableHeader>
          <TableBody>
            {schedules?.map((schedule) => (
              <TableRow key={schedule.scheduleId}>
                <TableCell>{schedules?.indexOf(schedule)+1}</TableCell>
                <TableCell>{schedule.dayOfWeek}:{schedule.time}</TableCell>
                <TableCell>{schedule.group}</TableCell>
                <TableCell>{classs?.roomId}</TableCell>
                <TableCell>{classs?.instructor}</TableCell>
                <TableCell>{classs?.semester}</TableCell>
              </TableRow>
            ))}
          </TableBody>
          <TableFooter></TableFooter>
        </Table>
        <div className="flex justify-center pt-6">
          <Button
          onClick={ async()=>{
            // post()
          }}
          >Đăng ký môn học</Button>
        </div>
      </div>
    </div>
  );
}
