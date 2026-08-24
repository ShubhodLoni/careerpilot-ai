"use client";
import ATSGauge from "../dashboard/ATSGauge";
import { useState } from "react";

const API_BASE_URL = "https://careerpilot-ai-3-mhol.onrender.com";

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
    } catch (error: any) {
  console.error("FULL ERROR:", error);

  if (error instanceof Error) {
    alert(error.message);
  } else {
    alert(JSON.stringify(error));
  }
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



            {/* Career Match Analysis */}
            <div className="rounded-3xl border border-indigo-500/20 bg-white/5 p-6 backdrop-blur-xl">
              <h3 className="mb-4 text-lg font-semibold text-indigo-400">
                🎯 Career Match Analysis
              </h3>

              {result.careerMatches?.length > 0 ? (
                <div className="space-y-5">
                  {result.careerMatches.map(
                    (
                      career: {
                        role: string;
                        category: string;
                        salaryRange: string;
                        matchScore: number;
                      },
                      index: number
                    ) => (
                      <div
                        key={index}
                        className="rounded-2xl border border-indigo-500/10 bg-indigo-500/5 p-5"
                      >
                        <div className="flex items-start justify-between">
                          <div>
                            <h4 className="text-lg font-bold text-white">
                              🎯 {career.role}
                            </h4>

                            <p className="mt-1 text-sm text-slate-400">
                              📂 {career.category}
                            </p>

                            <p className="mt-1 text-sm text-green-400">
                              💰 {career.salaryRange}
                            </p>
                          </div>

                          <div className="text-right">
                            <p className="text-2xl font-bold text-indigo-300">
                              {career.matchScore}%
                            </p>

                            <p className="text-xs text-slate-500">
                              Match Score
                            </p>
                          </div>
                        </div>

                        <div className="mt-4 h-3 w-full rounded-full bg-slate-700">
                          <div
                            className="h-3 rounded-full bg-gradient-to-r from-indigo-500 via-purple-500 to-pink-500 transition-all duration-700"
                            style={{
                              width: `${career.matchScore}%`,
                            }}
                          />
                        </div>

                        <div className="mt-3 flex justify-between text-xs text-slate-400">
                          <span>Beginner Fit</span>
                          <span>Strong Fit</span>
                        </div>
                      </div>
                    )
                  )}
                </div>
              ) : (
                <p className="text-slate-400">
                  No career matches available.
                </p>
              )}
            </div>
            {/* Missing Skills */}
<div className="rounded-3xl border border-red-500/20 bg-white/5 p-6 backdrop-blur-xl">
  <h3 className="mb-4 text-lg font-semibold text-red-400">
    🚀 Skill Gaps to Unlock Better Roles
  </h3>

  {result.missingSkills?.length > 0 ? (
    <div className="flex flex-wrap gap-3">
      {result.missingSkills.map(
        (skill: string, index: number) => (
          <span
            key={index}
            className="rounded-full bg-red-500/20 px-4 py-2 text-red-300"
          >
            🔥 {skill}
          </span>
        )
      )}
    </div>
  ) : (
    <p className="text-green-400">
      🎉 No major skill gaps detected!
    </p>
  )}
</div>
            {/* Recommended Learning */}
<div className="rounded-3xl border border-emerald-500/20 bg-white/5 p-6 backdrop-blur-xl">
  <h3 className="mb-4 text-lg font-semibold text-emerald-400">
    🎓 Recommended Learning
  </h3>

  {result.recommendedCourses?.length > 0 ? (
    <div className="space-y-4">
      {result.recommendedCourses.map(
        (
          course: {
            course: string;
            missingSkill: string;
          },
          index: number
        ) => (
          <div
            key={index}
            className="rounded-xl bg-emerald-500/10 p-4"
          >
            <h4 className="font-semibold text-white">
              {course.course}
            </h4>

            <p className="mt-1 text-sm text-slate-400">
              {course.missingSkill}
            </p>
          </div>
        )
      )}
    </div>
  ) : (
    <p className="text-slate-400">
      No recommendations available.
    </p>
  )}
</div>



            <div className="mt-6 rounded-3xl border border-purple-500/20 bg-white/5 p-6 backdrop-blur-xl">
              <h2 className="text-xl font-bold text-purple-400 mb-4">
                🤖 AI Career Coach
              </h2>

              <div className="whitespace-pre-wrap rounded-2xl bg-slate-900/40 p-6 text-slate-200 text-lg leading-8 font-medium">
                {result.aiFeedback}
              </div>
            </div>
          </div>
        )}

      </div>
    </section>
  );
}