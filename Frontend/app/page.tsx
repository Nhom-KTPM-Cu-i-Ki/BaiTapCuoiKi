

"use client";

import { Avatar, AvatarFallback, AvatarImage } from "@/components/ui/avatar";
import Link from "next/link";
import { useEffect, useState } from "react";
import { get } from "@/lib/http";

import { Button } from "@/components/ui/button";
import Cookies from "js-cookie";
import { useRouter } from "next/navigation";

export default function Home() {
  const router = useRouter();
  const [students, setStudents] = useState([]);
  const [error, setError] = useState(null);

  useEffect(() => {
    const fetchStudents = async () => {
      try {
        const res: any = await get("/api/v1/students");
        setStudents(res.data);
      } catch (error: any) {
        setError(error.message);
      }
    };
    fetchStudents();
  }, []);

  const handleLogout = async () => {
    Cookies.remove("token");
    router.push("/login");
  };


  return (
    <main className="flex flex-col items-center justify-between p-24 bg-slate-200 h-auto">
      <div className="w-full">
        <h1
          className="flex justify-center items-center text-3xl pb-4"
          role="action"
        >
          Thông tin sinh viên
        </h1>
        <div className="flex" role="information-student">
          <div className="w-1/5 flex justify-center items-center" role="image">
            <Avatar className="w-24 h-24 rounded-full">
              <AvatarImage src="https://github.com/shadcn.png" />
              <AvatarFallback>CN</AvatarFallback>
            </Avatar>
          </div>
          <div className="w-2/5 leading-8" role="information-1">
            <ul>
              {students.map((student: any, index) => (
                <li key={index}>MSSV: {student.mssv}</li>
              ))}
            </ul>
          </div>
          <div className="w-2/5 leading-8" role="information-2">
            <ul>
              {students.map((student: any, index) => (
                <li key={index}>MSSV: {student.mssv}</li>
              ))}
            </ul>
          </div>
        </div>
      </div>
      <div className="w-full h-full p-4 flex" role="courses-registration">
        <Link
          href="/registration-courses"
          className="bg-slate-300 w-1/6 h-16 flex justify-center items-center"
          role="header"
        >
          Đăng ký học phần
        </Link>
        <Link
          href="/mark-student"
          className="bg-slate-300 w-1/6 h-16 flex justify-center items-center ml-4"
          role="header"
        >
          Xem bảng điểm
        </Link>
        <div className="" role="table"></div>
      </div>
      <div className="" role="class-registration"></div>
      <div className="" role="detail-class-registration"></div>
      <div className="" role="registered-courses"></div>
      <Button onClick={handleLogout}>Log out</Button>
      {error && <div className="text-red-500">Error: {error}</div>}
    </main>
  );
}
