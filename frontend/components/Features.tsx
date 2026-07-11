export default function Features() {
  return (
    <section id="features" className="py-24 px-6">
      <h2 className="text-4xl font-bold text-center mb-12">
        Features
      </h2>

      <div className="grid md:grid-cols-3 gap-6 max-w-6xl mx-auto">

        <div className="rounded-3xl bg-white/5 p-6">
          📄 Resume Analysis
        </div>

        <div className="rounded-3xl bg-white/5 p-6">
          🎯 ATS Score
        </div>

        <div className="rounded-3xl bg-white/5 p-6">
          🚀 Career Match Analysis
        </div>

        <div className="rounded-3xl bg-white/5 p-6">
          📈 Skill Gap Detection
        </div>

        <div className="rounded-3xl bg-white/5 p-6">
          📚 Course Recommendations
        </div>

        <div className="rounded-3xl bg-white/5 p-6">
          🤖 AI Career Coach
        </div>

      </div>
    </section>
  );
}