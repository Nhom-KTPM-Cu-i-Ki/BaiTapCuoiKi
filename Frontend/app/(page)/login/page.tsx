"use client";
import { useState } from "react";
import { useRouter } from "next/navigation";
import Cookies from "js-cookie";
import { post } from "@/lib/http";
import { Label } from "@/components/ui/label";
import { Input } from "@/components/ui/input";
import { Button } from "@/components/ui/button";
import Link from "next/link";

export default function LoginPage() {
  const router = useRouter();
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [error, setError] = useState("");
  const handleLogin = async () => {
    try {
      const response = await post(
        `${process.env.NEXT_PUBLIC_API_ENDPOINT}/api/v1/auth/token`,
        { username, password }
      );
      if (response.status >= 200 && response.status < 300 && response.data) {
        const token = response.data.toString();
        Cookies.set("token", token);
        // Chuyển hướng sau khi đăng nhập thành công
        router.push("/");
      } else {
        // Handle error if response is not ok
        const errorMessage = await response.toString();
        setError(errorMessage);
      }
    } catch (error) {
      console.error("Login failed:", error);
      setUsername("");
      setPassword("");
      setError("Invalid email or password. Please try again.");
    }
  };

  return (
    <div className="flex h-screen items-center justify-center bg-white">
      <div className="w-full max-w-sm rounded-md bg-white p-8 shadow-2xl">
        <h1 className="mb-4 text-center text-2xl font-bold">Login</h1>
        <p className="mb-4 text-center">
          Enter your username and password to login to the admin page.
        </p>
        {error && <p className="mb-4 text-red-500">{error}</p>}
        <div className="space-y-4">
          <div className="space-y-2">
            <Label htmlFor="username">Username</Label>
            <Input
              id="username"
              required
              type="text"
              value={username}
              onChange={(e) => setUsername(e.target.value)}
              className="border-gray-400"
            />
          </div>
          <div className="space-y-2">
            <Label htmlFor="password">Password</Label>
            <Input
              id="password"
              required
              type="password"
              value={password}
              onChange={(e) => setPassword(e.target.value)}
              className="border-gray-400"
            />
          </div>
          <Button className="w-full" type="submit" onClick={handleLogin}>
            Login
          </Button>
          <Link href="/forgot-password">Forgot Password?</Link>
        </div>
      </div>
    </div>
  );
}
