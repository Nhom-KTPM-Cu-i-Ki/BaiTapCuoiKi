import { Avatar, AvatarFallback, AvatarImage } from "@/components/ui/avatar";
import Link from "next/link";
import { get } from "@/lib/http";
export default function Home() {
  // Test API HTTP
  return (
    <main className="flex flex-col items-center justify-between p-24 bg-slate-200 h-auto">
      <div className=" w-full">
        <h1
          className="flex justify-center items-center text-3xl pb-4"
          role="action"
        >
          Thông tin sinh viên
        </h1>
        <div className="flex" role="infomation-student">
          <div className="w-1/5 flex justify-center items-center " role="image">
            <Avatar className="w-24 h-5/5 rounded-full">
              <AvatarImage src="https://github.com/shadcn.png" />
              <AvatarFallback>CN</AvatarFallback>
            </Avatar>
          </div>
          <div className="w-2/5 leading-8" role="information-1">
            <ul className="">
              <li>MSSV: 19491261</li>
              <li>MSSV: 19491261</li>
              <li>MSSV: 19491261</li>
              <li>MSSV: 19491261</li>
              <li>MSSV: 19491261</li>
            </ul>
          </div>
          <div className="w-2/5 leading-8" role="information-2">
            <ul>
              <li>MSSV: 19491261</li>
              <li>MSSV: 19491261</li>
              <li>MSSV: 19491261</li>
              <li>MSSV: 19491261</li>
              <li>MSSV: 19491261</li>
            </ul>
          </div>
        </div>
      </div>
      <div className="w-full h-full p-4 flex" role="courses-registration">
        <Link
          href={"/registration-courses"}
          className="bg-slate-300 w-1/6 h-16 flex justify-center items-center"
          role="header"
        >
          Dang ky hoc phan
        </Link>
        <Link
          href={"/mark-student"}
          className="bg-slate-300 w-1/6 h-16 flex justify-center items-center ml-4"
          role="header"
        >
          Xem bảng điểm
        </Link>
        <div className="" role="table"></div>
      </div>
      <div className="" role="class-registration"></div>
      <div className="" role="detail-class-registration"></div>
      <div className="" role="registrated courses"></div>
    </main>
  );
}
