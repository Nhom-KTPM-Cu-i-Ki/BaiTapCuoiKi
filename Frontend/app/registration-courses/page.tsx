"use client"
import { Checkbox } from "@/components/ui/checkbox";
import React, { useState } from "react";
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
import DetailClassCredit from "@/components/DetailClassCredit";
import ClassRegistration from "@/components/ClassRegistration";
import { Button } from "@/components/ui/button";

import Link from "next/link";

const invoices = [
  {
    icon: true,
    stt: "1",
    maMH: "2106529",
    maHP: "4203003194",
    tenMH: "Hội họa",
    tc: "3",
    hocphan: "002137",
  },
  {
    icon: true,
    stt: "1",
    maMH: "2106529",
    maHP: "4203003194",
    tenMH: "Hội họa",
    tc: "3",
    hocphan: "002137",
  },
  {
    icon: true,
    stt: "1",
    maMH: "2106529",
    maHP: "4203003194",
    tenMH: "Hội họa",
    tc: "3",
    hocphan: "002137",
  },
  {
    icon: true,
    stt: "1",
    maMH: "2106529",
    maHP: "4203003194",
    tenMH: "Hội họa",
    tc: "3",
    hocphan: "002137",
  },
  {
    icon: true,
    stt: "1",
    maMH: "2106529",
    maHP: "4203003194",
    tenMH: "Hội họa",
    tc: "3",
    hocphan: "002137",
  },
];

function RegistrationCourses() {
  const [shouldUpdate, setShouldUpdate] = useState<boolean>(false);

  const handleUpdate = () => {
    setShouldUpdate(prevState => !prevState);
     // Kích hoạt việc render lại toàn bộ trang
     console.log(shouldUpdate)
  };
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
              <TableHead className="w-[100px]"></TableHead>
              <TableHead className="w-[100px]">STT</TableHead>
              <TableHead>Mã MH cũ</TableHead>
              <TableHead>Mã HP</TableHead>
              <TableHead>Tên môn học</TableHead>
              <TableHead>TC</TableHead>
              <TableHead>Tiên quyết</TableHead>
            </TableRow>
          </TableHeader>
          <TableBody>
            {invoices.map((invoice) => (
              <TableRow key={invoice.stt}>
                <TableCell className="font-medium">
                  {" "}
                  {invoice.icon ? <Checkbox /> : ""}
                </TableCell>
                <TableCell>{invoice.stt}</TableCell>
                <TableCell>{invoice.maMH}</TableCell>
                <TableCell>{invoice.maHP}</TableCell>
                <TableCell>{invoice.tenMH}</TableCell>
                <TableCell>{invoice.tc}</TableCell>
                <TableCell>{invoice.hocphan}</TableCell>
              </TableRow>
            ))}
          </TableBody>
          <TableFooter></TableFooter>
        </Table>
      </div>
      <ClassCredit  />
      <ClassRegistration shouldUpdate={handleUpdate} />
    </div>
  );
}

export default RegistrationCourses;
