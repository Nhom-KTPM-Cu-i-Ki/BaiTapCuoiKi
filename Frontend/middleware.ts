import { NextRequest, NextResponse } from "next/server";
import { cookies } from "next/headers";
export default async function middleware(req: NextRequest) {
  // If there is no token, redirect to /login

  const cookieStore = cookies();
  const token = cookieStore.get("token");
  console.log(token);

  if (!token) {
    return NextResponse.redirect(new URL("/login", req.url));
  }

  return NextResponse.next();
}

export const config = {
  matcher: ["/mark-student", "/", "/registration-courses"],
};
