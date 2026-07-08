import Navbar from "../components/layout/Navbar";
import FeatureOrbit from "../components/landing/FeatureOrbit";
import AIAgentOrb from "../components/landing/AIAgentOrb";

export default function Home() {
  return (
    <main className="relative min-h-screen overflow-hidden bg-gradient-to-b from-[#050816] via-[#0B1020] to-[#111827] text-white">

      {/* Aurora Background */}
      <div className="absolute inset-0 overflow-hidden">
        <div className="absolute left-1/4 top-1/4 h-96 w-96 rounded-full bg-purple-500/20 blur-[120px]" />
        <div className="absolute right-1/4 top-1/3 h-96 w-96 rounded-full bg-blue-500/20 blur-[120px]" />
        <div className="absolute bottom-1/4 left-1/2 h-96 w-96 rounded-full bg-violet-500/20 blur-[120px]" />
      </div>

      <Navbar />

      <section className="relative z-10 flex min-h-screen flex-col items-center px-6 pt-40">

        {/* Badge */}
        <div className="mb-8 rounded-full border border-purple-500/20 bg-purple-500/10 px-5 py-2 text-sm text-purple-300">
          CareerPilot AI
        </div>

        {/* Heading */}
        <h1 className="max-w-4xl text-center text-4xl font-bold leading-tight md:text-5xl lg:text-6xl">
          Your Autonomous Career Intelligence Agent
        </h1>

        {/* Description */}
        <p className="mt-6 max-w-2xl text-center text-lg text-slate-400">
          Upload your resume and let your AI Career Agent analyze,
          evaluate, score and accelerate your career journey.
        </p>

        {/* Orb Section */}
        <div className="relative mt-24 mb-16">
          <FeatureOrbit />
          <AIAgentOrb />
        </div>

        {/* Status Card */}
        <div className="rounded-2xl border border-white/10 bg-white/5 px-8 py-5 backdrop-blur-xl">
          <p className="text-sm text-slate-400">
            Agent Status
          </p>

          <p className="mt-1 font-semibold text-green-400">
            Ready to Analyze
          </p>
        </div>

        {/* CTA */}
        <button className="mt-8 rounded-2xl bg-gradient-to-r from-purple-600 to-violet-500 px-8 py-4 font-medium transition hover:scale-105">
          Launch Career Agent
        </button>

        {/* Activity */}
        <div className="mt-16 mb-20 w-full max-w-2xl rounded-3xl border border-white/10 bg-white/5 p-8 backdrop-blur-xl">

          <h2 className="mb-6 text-xl font-semibold">
            Agent Activity
          </h2>

          <div className="space-y-4">
            <div className="flex items-center gap-3">
              <span className="text-green-400">✓</span>
              <span>Resume Uploaded</span>
            </div>

            <div className="flex items-center gap-3">
              <span className="text-green-400">✓</span>
              <span>Skills Extracted</span>
            </div>

            <div className="flex items-center gap-3">
              <span className="text-green-400">✓</span>
              <span>ATS Score Generated</span>
            </div>

            <div className="flex items-center gap-3">
              <span className="text-green-400">✓</span>
              <span>Career Roadmap Created</span>
            </div>

            <div className="flex items-center gap-3">
              <span className="text-green-400">✓</span>
              <span>Job Recommendations Ready</span>
            </div>
          </div>

        </div>

      </section>
    </main>
  );
}