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
import { get, remove,} from "@/lib/http";

interface ClassRegistrationProps {
  shouldUpdate: () => void;
}
export default function ClassRegistration({ shouldUpdate }: ClassRegistrationProps) {
  const [enrollments, setEnrollments] = useState<any[]>([]);
  const getAllEnrollments =async ()=>{
    try {
      const res = await get<any[]>("/api/v1/enrollments/studentId/1");
      const data = res.data;
      setEnrollments(data);
    } catch (error) {
      console.log(error)
    }
  }
  const handleDelte =async (invoice:any)=>{
    try {
      const studentId  =1
      const classId = invoice.classId.classId
      const res = await remove(`/api/v1/enrollments/studentId/${studentId}/classId/${classId}`);
      setEnrollments(enrollments.filter(item => item.classId.classId !== classId));
      shouldUpdate();
      alert("Xóa thành công")
    } catch (error) {
      console.log(error)
      alert("Xóa thất bại")
    }
  }
  useEffect(() => {
    getAllEnrollments();
  }, []);
  console.log(enrollments)
  return (
    <div className="pb-6">
      <div className="flex text-3xl justify-center pb-6">
        Lớp học phần đã đăng ký
      </div>
      <div className="w-auto h-auto pb-6 border-b-[16px]">
        <Table>
          <TableHeader>
            <TableRow>
              <TableHead className="w-[100px]">STT</TableHead>
              <TableHead>Mã LHP</TableHead>
              <TableHead>Tên môn học</TableHead>
              <TableHead>Lớp học dự kiến</TableHead>
              <TableHead>Số TC</TableHead>
              <TableHead>Nhóm TH</TableHead>
              <TableHead>Học phí</TableHead>
              <TableHead>Ngày ĐK</TableHead>
            </TableRow>
          </TableHeader>
          <TableBody>
            {enrollments.map((invoice,index) => (
              <TableRow key={invoice.stt}>
                
                <TableCell className="font-medium">{invoice.stt}</TableCell>
                <TableCell>{invoice.classId.classId}</TableCell>
                <TableCell>{invoice.tenMH}</TableCell>
                <TableCell>{invoice.lopHocDuKien}</TableCell>
                <TableCell>{invoice.creditEarned}</TableCell>
                <TableCell>{invoice.nhomTH}</TableCell>
                <TableCell>{invoice.tuitionFee}</TableCell>
                <TableCell>{invoice.registrationDate}</TableCell>
                <Button onClick={()=>{handleDelte(invoice)}}>Hủy</Button>
              </TableRow>
            ))}
          </TableBody>
          <TableFooter></TableFooter>
        </Table>
      </div>
    </div>
  );
}
