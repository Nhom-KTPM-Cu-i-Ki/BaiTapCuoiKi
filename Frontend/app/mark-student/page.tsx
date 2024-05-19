'use client'
import React, { useEffect, useState } from "react";
import MarkClass from "@/components/MarkClass";
import { Avatar, AvatarFallback, AvatarImage } from "@/components/ui/avatar";
import { get } from "@/lib/http";
interface Student{
  studentId: number,
  userId: number,
  name: string,
  totalCredits: number
}

export default function MarkStudent() {
  const student_id = 1
  const [student,setStudent] = useState<Student>();

  useEffect(() => {
    const fetchCourses = async () => {
      try {
        const res = await get<Student>("/api/v1/academy/students/student_id/"+student_id);
        const data = res.data;
        setStudent(data)
      } catch (error) {
        console.error("Failed to fetch courses", error);
      }
    };
    fetchCourses();
  }, []);
  return (
    <div className="flex flex-col justify-between p-24">
      <div className="flex w-full" role="infomation-student">
        <div className="w-2/12 flex justify-center items-center " role="image">
          <Avatar className="w-24 h-5/5 rounded-full">
            <AvatarImage src="https://github.com/shadcn.png" />
            <AvatarFallback>CN</AvatarFallback>
          </Avatar>
        </div>

        <div className="w-3/12 leading-8" role="information-2">
          <ul>
            <li>Họ tên: {student?.name}</li>
            <li>Mã số sinh viên: {student?.studentId}</li>
            <li>Tổng số tín chỉ: {student?.totalCredits}</li>
          </ul>
        </div>
        <div className="flex items-center w-7/12 text-3xl ">
          Xem điểm các môn học
        </div>
      </div>
      <MarkClass />
    </div>
  );
}
