"use client";
import ATSGauge from "../dashboard/ATSGauge";
import { useState } from "react";

const API_BASE_URL = "http://localhost:8080";

export default function ResumeUpload() {
  const [fileName, setFileName] = useState("");
  const [selectedFile, setSelectedFile] = useState<File | null>(null);
  const [loading, setLoading] = useState(false);
  const [result, setResult] = useState<any>(null);

  const handleFileChange = (
    e: React.ChangeEvent<HTMLInputElement>
  ) => {
    const file = e.target.files?.[0];

    if (file) {
      setFileName(file.name);
      setSelectedFile(file);
    }
  };

  const handleAnalyze = async () => {
    if (!selectedFile) {
      alert("Please select a resume first");
      return;
    }

    try {
      setLoading(true);

      const formData = new FormData();

      formData.append("file", selectedFile);

      const response = await fetch(
        `${API_BASE_URL}/api/resume/upload`,
        {
          method: "POST",
          body: formData,
        }
      );

      if (!response.ok) {
        throw new Error("Upload failed");
      }

      const data = await response.json();

      setResult(data);
    } catch (error) {
      console.error(error);
      alert("Failed to analyze resume");
    } finally {
      setLoading(false);
    }
  };

  return (
    <section className="w-full px-6 py-20">
      <div className="mx-auto max-w-3xl rounded-3xl border border-white/10 bg-white/5 p-8 backdrop-blur-xl">

        <h2 className="mb-2 text-center text-3xl font-bold text-white">
          Upload Resume
        </h2>

        <p className="mb-8 text-center text-slate-400">
          Let CareerPilot AI analyze your profile and generate insights.
        </p>

        <label
          htmlFor="resume"
          className="flex min-h-[250px] cursor-pointer flex-col items-center justify-center rounded-2xl border-2 border-dashed border-purple-500/40 transition hover:border-purple-400 hover:bg-white/5"
        >
          <div className="text-6xl">📄</div>

          <h3 className="mt-4 text-xl font-semibold">
            Drag & Drop Resume
          </h3>

          <p className="mt-2 text-slate-400">
            PDF or DOCX files supported
          </p>

          <input
            id="resume"
            type="file"
            accept=".pdf,.doc,.docx"
            className="hidden"
            onChange={handleFileChange}
          />
        </label>

        {fileName && (
          <div className="mt-6 rounded-xl border border-green-500/20 bg-green-500/10 p-4 text-center text-green-400">
            Selected File: {fileName}
          </div>
        )}

        <button
          onClick={handleAnalyze}
          disabled={loading}
          className="mt-8 w-full rounded-2xl bg-gradient-to-r from-purple-600 to-violet-500 py-4 font-semibold transition hover:scale-[1.02] disabled:opacity-50"
        >
          {loading ? "Analyzing..." : "Analyze Resume"}
        </button>

        {result && (
  <div className="mt-10 space-y-6">

    {/* ATS Score */}
    <div className="rounded-3xl border border-purple-500/20 bg-white/5 p-6 backdrop-blur-xl">
      <h3 className="text-lg font-semibold text-purple-300">
        ATS Score
      </h3>

      <ATSGauge score={result.atsScore} />
    </div>

    {/* Skills Found */}
    <div className="rounded-3xl border border-green-500/20 bg-white/5 p-6 backdrop-blur-xl">
      <h3 className="mb-4 text-lg font-semibold text-green-400">
        Skills Found
      </h3>

      <div className="flex flex-wrap gap-3">
        {result.skillsFound?.map(
          (skill: string, index: number) => (
            <span
              key={index}
              className="rounded-full bg-green-500/20 px-4 py-2 text-green-300"
            >
              {skill}
            </span>
          )
        )}
      </div>
    </div>

    {/* Missing Skills */}
    <div className="rounded-3xl border border-red-500/20 bg-white/5 p-6 backdrop-blur-xl">
      <h3 className="mb-4 text-lg font-semibold text-red-400">
        Missing Skills
      </h3>

      <div className="flex flex-wrap gap-3">
        {result.missingSkills?.map(
          (skill: string, index: number) => (
            <span
              key={index}
              className="rounded-full bg-red-500/20 px-4 py-2 text-red-300"
            >
              {skill}
            </span>
          )
        )}
      </div>
    </div>

    {/* Recommended Roles */}
    <div className="rounded-3xl border border-blue-500/20 bg-white/5 p-6 backdrop-blur-xl">
      <h3 className="mb-4 text-lg font-semibold text-blue-400">
        Recommended Roles
      </h3>

      <div className="space-y-3">
        {result.recommendedRoles?.map(
          (role: string, index: number) => (
            <div
              key={index}
              className="rounded-xl bg-blue-500/10 p-3"
            >
              {role}
            </div>
          )
        )}
      </div>
    </div>
{/* Career Roadmap */}
<div className="rounded-3xl border border-yellow-500/20 bg-white/5 p-6 backdrop-blur-xl">
  <h3 className="mb-4 text-lg font-semibold text-yellow-400">
    Career Roadmap
  </h3>

  <div className="space-y-3">
    {result.careerRoadmap?.map(
      (step: string, index: number) => (
        <div
          key={index}
          className="rounded-xl bg-yellow-500/10 p-3"
        >
          {index + 1}. {step}
        </div>
      )
    )}
  </div>
</div>
  </div>
)}

      </div>
    </section>
  );
}