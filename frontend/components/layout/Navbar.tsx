import Link from "next/link";

export default function Navbar() {
  return (
    <nav className="fixed top-5 left-1/2 z-50 w-[90%] max-w-6xl -translate-x-1/2">
      <div className="flex items-center justify-between rounded-2xl border border-white/10 bg-white/5 px-6 py-4 backdrop-blur-xl">

        <h1 className="text-lg font-bold text-white">
          CareerPilot AI
        </h1>

        <div className="hidden gap-8 text-sm text-slate-300 md:flex">
          <a href="#home">Home</a>
          <a href="#features">Features</a>
          <a href="#roadmap">Roadmap</a>
          <a href="#dashboard">Dashboard</a>
        </div>

        <a
          href="#resume-upload"
          className="rounded-xl bg-purple-600 px-4 py-2 text-sm font-medium"
        >
          Get Started
        </a>

      </div>
    </nav>
  );
}