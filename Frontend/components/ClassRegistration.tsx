import React from "react";
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

const invoices = [
  {
    stt: "1",
    maLHP: "420300154901",
    tenMH: "Kiến trúc và Thiết kế phần mềm",
    lopHocDuKien: "DHKTPM16A",
    soTC: "4",
    nhomTH: "3",
    hocPhi: "3,010,000",
    ngayDK: "25/12/2023",
  },
  {
    stt: "1",
    maLHP: "420300154901",
    tenMH: "Kiến trúc và Thiết kế phần mềm",
    lopHocDuKien: "DHKTPM16A",
    soTC: "4",
    nhomTH: "3",
    hocPhi: "3,010,000",
    ngayDK: "25/12/2023",
  },
  {
    stt: "1",
    maLHP: "420300154901",
    tenMH: "Kiến trúc và Thiết kế phần mềm",
    lopHocDuKien: "DHKTPM16A",
    soTC: "4",
    nhomTH: "3",
    hocPhi: "3,010,000",
    ngayDK: "25/12/2023",
  },
];

export default function ClassRegistration() {
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
            {invoices.map((invoice) => (
              <TableRow key={invoice.stt}>
                <TableCell className="font-medium">{invoice.stt}</TableCell>
                <TableCell>{invoice.maLHP}</TableCell>
                <TableCell>{invoice.tenMH}</TableCell>
                <TableCell>{invoice.lopHocDuKien}</TableCell>
                <TableCell>{invoice.soTC}</TableCell>
                <TableCell>{invoice.nhomTH}</TableCell>
                <TableCell>{invoice.hocPhi}</TableCell>
                <TableCell>{invoice.ngayDK}</TableCell>
              </TableRow>
            ))}
          </TableBody>
          <TableFooter></TableFooter>
        </Table>
      </div>
    </div>
  );
}
