export default function Roadmap() {
  return (
    <section id="roadmap" className="py-24 px-6">

      <h2 className="text-4xl font-bold text-center mb-12">
        Product Roadmap
      </h2>

      <div className="max-w-4xl mx-auto space-y-6">

        <div className="rounded-3xl bg-green-500/10 p-6">
          ✅ Resume Upload
        </div>

        <div className="rounded-3xl bg-green-500/10 p-6">
          ✅ ATS Score Analysis
        </div>

        <div className="rounded-3xl bg-green-500/10 p-6">
          ✅ Career Match Analysis
        </div>

        <div className="rounded-3xl bg-yellow-500/10 p-6">
          🚧 Job Description Matching
        </div>

        <div className="rounded-3xl bg-yellow-500/10 p-6">
          🚧 AI Resume Builder
        </div>

        <div className="rounded-3xl bg-purple-500/10 p-6">
          🔮 AI Job Application Assistant
        </div>

      </div>

    </section>
  );
}