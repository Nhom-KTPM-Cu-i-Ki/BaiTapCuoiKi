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

const invoices = [
  {
    stt: "1",
    maLHP: "420300233002",
    tenLHP: "Lập trình phân tích dữ liệu 2",
    lop: "DHKTPM16A",
    thuongKy1: "3",
    thuongKy2: "6",
    cuoiKi: "9",
  },
  {
    stt: "1",
    maLHP: "420300233002",
    tenLHP: "Lập trình phân tích dữ liệu 2",
    lop: "DHKTPM16A",
    thuongKy1: "3",
    thuongKy2: "6",
    cuoiKi: "9",
  },
  {
    stt: "1",
    maLHP: "420300233002",
    tenLHP: "Lập trình phân tích dữ liệu 2",
    lop: "DHKTPM16A",
    thuongKy1: "3",
    thuongKy2: "6",
    cuoiKi: "9",
  },
];

export default function MarkClass() {
  return (
    <div className="pb-6">
      <div className="flex text-3xl justify-center pb-4 border-b-2 pt-6">
        Điểm môn ....
      </div>
      <div className="w-auto h-auto pb-6 border-b-[16px]">
        <Table>
          <TableHeader>
            <TableRow>
              <TableHead className="text-center">STT</TableHead>
              <TableHead className="text-center">Mã LHP</TableHead>
              <TableHead>Tên lớp học phần</TableHead>
              <TableHead className="text-center">Lớp</TableHead>
              <TableHead className="text-center">Thường kỳ 1</TableHead>
              <TableHead className="text-center">Thường kỳ 2</TableHead>
              <TableHead className="text-center">Cuối kỳ </TableHead>
            </TableRow>
          </TableHeader>
          <TableBody>
            {invoices.map((invoice) => (
              <TableRow key={invoice.maLHP}>
                <TableCell className="text-center">{invoice.stt}</TableCell>
                <TableCell className="text-center">{invoice.maLHP}</TableCell>
                <TableCell>{invoice.tenLHP}</TableCell>
                <TableCell className="text-center">{invoice.lop}</TableCell>
                <TableCell className="text-center">
                  {invoice.thuongKy1}
                </TableCell>
                <TableCell className="text-center">
                  {invoice.thuongKy2}
                </TableCell>
                <TableCell className="text-center">{invoice.cuoiKi}</TableCell>
              </TableRow>
            ))}
          </TableBody>
          <TableFooter></TableFooter>
        </Table>
      </div>
    </div>
  );
}
