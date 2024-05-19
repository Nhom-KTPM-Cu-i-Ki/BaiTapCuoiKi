import React from "react";
import MarkClass from "@/components/MarkClass";
import { Avatar, AvatarFallback, AvatarImage } from "@/components/ui/avatar";

export default function MarkStudent() {
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
            <li>MSSV: 19491261</li>
            <li>MSSV: 19491261</li>
            <li>MSSV: 19491261</li>
            <li>MSSV: 19491261</li>
            <li>MSSV: 19491261</li>
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
