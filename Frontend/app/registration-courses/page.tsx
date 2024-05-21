"use client"
import { Checkbox } from "@/components/ui/checkbox";
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
import ClassCredit from "@/components/ClassCredit";
import ClassRegistration from "@/components/ClassRegistration";
import { Button } from "@/components/ui/button";
import Link from "next/link";
import { get } from "@/lib/http";

interface Course {
  courseId: number,
  courseName: string,
  credits: number,
  department: {
    departmentName: string,
  }
  prerequisites: Course[]
}

function RegistrationCourses() {
  const [selectedCourse, setSelectedCourse] = useState<Course>();
  const [courses, setCourses] = useState<Course[]>([])
  const department = 1;
  const student = 2;
  useEffect(() => {
    const fetchCourses = async () => {

      try {
        const res = await get("/api/v1/courses/course_require/department/" + department + "/student/" + student);
        const data = res.data;
        setCourses(data as Course[]);
      } catch (error) {
        console.error("Failed to fetch courses", error);
      }
    };

    fetchCourses();
  }, []);

  return (
    <div className="w-full h-auto p-8 ">
      <Link
        className="w-2/12 text-left p-4 bg-slate-500 rounded-3xl"
        href={"/"}
      >
        GO BACK
      </Link>
      <div className="flex justify-center items-center text-3xl pb-4">
        <span> Đăng ký học phần</span>
      </div>
      <div className="w-auto h-auto border-b-[16px]">
        <Table>
          <TableHeader>
            <TableRow>
              <TableHead className="w-[100px]">STT</TableHead>
              <TableHead>Mã môn học</TableHead>
              <TableHead>Tên môn học</TableHead>
              <TableHead>Số tín chỉ</TableHead>
            </TableRow>
          </TableHeader>
          <TableBody>
            {courses.map((course) => (
              <TableRow key={course.courseId}
                onClick={() => {
                  let temp = true; // Giả sử tất cả các điều kiện tiên quyết đều đã được đáp ứng
                  const promises = course.prerequisites.map(async (c) => {
                    const check = await get<boolean>(
                      `/api/v1/academy/grades/check/student_id/${student}/course_id/${c.courseId}`
                    );
                    temp = temp && check.data; // Kiểm tra xem tất cả các API call đều trả về true
                    console.log(temp);
                    return check; // Trả về Promise để Promise.all có thể chờ
                  });

                  Promise.all(promises).then(() => {
                    if (temp) {
                      setSelectedCourse(course);
                    } else {
                      alert("Môn này chưa thể đăng ký");
                    }
                  });
                }}
              >
                <TableCell>{courses.indexOf(course) + 1}</TableCell>
                <TableCell>{course.courseId}</TableCell>
                <TableCell>{course.courseName}</TableCell>
                <TableCell>{course.credits}</TableCell>
              </TableRow>
            )
            )}
          </TableBody>
        </Table>
      </div>
      {selectedCourse ? <ClassCredit course={selectedCourse} /> : null}
      <ClassRegistration />
    </div>
  );
}
// export default function ClassCredit({ course }: ClassCreditProps) {
//   const [classes,setClasses] = useState<Classs[]>([])
//   const [selectedClass, setSelectedClass] = useState<Classs>();
  
//   useEffect(() => {
//     const fetchCourses = async () => {
//       try {
//         console.log(course)
//         const res = await axios.get("http://localhost:8096/api/v1/class/course_id/"+course?.courseId);
//         const data = res.data;
//         setClasses(data as Classs[]);
//       } catch (error) {
//         console.error("Failed to fetch courses", error);
//       }
//     };
//     fetchCourses();
//   }, [course]);
export default RegistrationCourses;
