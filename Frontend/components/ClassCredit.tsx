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
import { Checkbox } from "./ui/checkbox";
import { get } from "@/lib/http";
import DetailClassCredit from "./DetailClassCredit";
import axios from "axios";




export default function ClassCredit({ course }: any) {
  const [classList, setClassList] = useState<any[]>([]);
  const [selectedClass, setSelectedClass] = useState<any>(null);
  
  const getAllClasses =async ()=>{
    try {
      const res = await axios.get("http://localhost:8096/api/v1/class");
      const data = res.data;
      setClassList(data);
    } catch (error) {
      console.log(error)
    }
  }
  const updateClassList = async () => {
    getAllClasses(); // Gọi lại hàm lấy toàn bộ dữ liệu
  };
  useEffect(() => {
    getAllClasses();
  }, []);
  const handleRowClick = (classItem: any) => {
    setSelectedClass(classItem);
  };
  return (
    <div className="pb-6">
      <div className="flex text-3xl justify-center pb-4 border-b-2 pt-6">
        Lớp học phần chờ đăng ký
      </div>
      <div className="w-auto h-auto pb-6 border-b-[16px]">
        <Table>
          <TableHeader>
            <TableRow>
              <TableHead className="w-[100px]"></TableHead>
              <TableHead>STT</TableHead>
              <TableHead>Mã LHP</TableHead>
              <TableHead>Tên lớp học phần</TableHead>
              <TableHead>Lớp dự kiến</TableHead>
              <TableHead>Sĩ số tối đa</TableHead>
              <TableHead>Đã đăng ký</TableHead>
              <TableHead>Tình trạng</TableHead>
            </TableRow>
          </TableHeader>
          <TableBody>
            {classList.map((classItem, index) => (
              <TableRow key={classItem.maLHP} 
              onClick={()=>{
                if(classItem.enrollmentCount>=classItem.maxStudents){
                  alert("Lớp đã đủ sinh viên")
                }
                else{
                  handleRowClick(classItem)
                }
              }}
               className="cursor-pointer">
                <TableCell className="font-medium">
                  {classItem.icon ? <Checkbox /> : ""}
                </TableCell>
                <TableCell>{index+1}</TableCell>
                <TableCell>{classItem.classId}</TableCell>
                <TableCell>{course.courseName}</TableCell>
                <TableCell>{classItem.roomId}</TableCell>
                <TableCell>{classItem.maxStudents}</TableCell>
                <TableCell>{classItem.enrollmentCount}</TableCell>
                <TableCell>{classItem.status}</TableCell>
              </TableRow>
            ))}
          </TableBody>
          <TableFooter></TableFooter>
        </Table>
      </div>
      {selectedClass && <DetailClassCredit classItem={selectedClass} updateClassList={updateClassList} />}
    </div>
  );
}
