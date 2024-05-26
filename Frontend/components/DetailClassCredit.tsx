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

export default function DetailClassCredit() {
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
            {invoices.map((invoice) => (
              <TableRow key={invoice.stt}>
                <TableCell>{invoice.stt}</TableCell>
                <TableCell>{invoice.lichhoc}</TableCell>
                <TableCell>{invoice.nhomTH}</TableCell>
                <TableCell>{invoice.phong}</TableCell>
                <TableCell>{invoice.giangvien}</TableCell>
                <TableCell>{invoice.tgian}</TableCell>
              </TableRow>
            ))}
          </TableBody>
          <TableFooter></TableFooter>
        </Table>
        <div className="flex justify-center pt-6">
          <Button>Đăng ký môn học</Button>
        </div>
      </div>
    </div>
  );
}
