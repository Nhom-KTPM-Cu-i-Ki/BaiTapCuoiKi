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
import { Button } from "./ui/button";
import { get, post, remove } from "@/lib/http";
export interface ClassItems {
  stt: string;
  classId: string;
  courseId: string;
  maxStudents: string;
  roomId: string;
  instructor: string;
  status: string;
}
interface DetailClassCreditProps {
  classItem: ClassItems;
  updateClassList: () => void;  // Prop mới
}
export default function DetailClassCredit({ classItem, updateClassList }: DetailClassCreditProps) {
  // const [classList, setClassList] = useState<any[]>([]);
  const classList = classItem;
  console.log(classList)
  const handleRegister = async () => {
    const req = {
      classId: classList.classId,
      studentId:1
    }
    try {
      const response =await post("/api/v1/enrollments",req);
      updateClassList(); 
      // alert("Thêm thành công thành công")
      console.log(response.data)
    } catch (error) {
      alert("Thêm thất bại");
    }
  }
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
            </TableRow>
          </TableHeader>
          <TableBody>         
              <TableRow >
                <TableCell>{classList.stt}</TableCell>
                <TableCell>{classList.courseId}</TableCell>
                <TableCell>{classList.courseId}</TableCell>
                <TableCell>{classList.roomId}</TableCell>
                <TableCell>{classList.instructor}</TableCell>
              </TableRow>
          </TableBody>
          <TableFooter></TableFooter>
        </Table>
        <div className="flex justify-center pt-6">
          <Button onClick={handleRegister}>Đăng ký môn học</Button>
        </div>
      </div>
    </div>
  );
}
