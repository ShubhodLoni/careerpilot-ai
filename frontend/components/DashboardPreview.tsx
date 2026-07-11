export default function DashboardPreview() {
  return (
    <section id="dashboard" className="py-24 px-6">

      <h2 className="text-4xl font-bold text-center mb-12">
        Dashboard Preview
      </h2>

      <div className="grid md:grid-cols-2 gap-6 max-w-6xl mx-auto">

        <div className="rounded-3xl bg-white/5 p-6">
          🎯 ATS Score
        </div>

        <div className="rounded-3xl bg-white/5 p-6">
          🚀 Career Matches
        </div>

        <div className="rounded-3xl bg-white/5 p-6">
          📈 Skill Gaps
        </div>

        <div className="rounded-3xl bg-white/5 p-6">
          📚 Recommended Courses
        </div>

      </div>

    </section>
  );
}