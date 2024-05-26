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
import { Checkbox } from "./ui/checkbox";

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

export default function ClassCredit() {
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
            </TableRow>
          </TableHeader>
          <TableBody>
            {invoices.map((invoice) => (
              <TableRow key={invoice.maLHP}>
                <TableCell className="font-medium">
                  {invoice.icon ? <Checkbox /> : ""}
                </TableCell>
                <TableCell>{invoice.stt}</TableCell>
                <TableCell>{invoice.maLHP}</TableCell>
                <TableCell>{invoice.tenLHP}</TableCell>
                <TableCell>{invoice.lopDukien}</TableCell>
                <TableCell>{invoice.siso}</TableCell>
                <TableCell>{invoice.daDangKy}</TableCell>
              </TableRow>
            ))}
          </TableBody>
          <TableFooter></TableFooter>
        </Table>
      </div>
    </div>
  );
}
