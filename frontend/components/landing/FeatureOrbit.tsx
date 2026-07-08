export default function FeatureOrbit() {
    return (
        <>
            <div className="absolute top-[-50px] left-1/2 -translate-x-1/2 whitespace-nowrap rounded-full border border-white/10 bg-white/5 px-6 py-2 text-sm backdrop-blur-xl">
                ATS Score
            </div>

            <div className="absolute left-[-180px] top-1/2 -translate-y-1/2 whitespace-nowrap rounded-full border border-white/10 bg-white/5 px-6 py-2 text-sm backdrop-blur-xl">
                Skill Gap Analysis
            </div>

            <div className="absolute right-[-150px] top-1/2 -translate-y-1/2 whitespace-nowrap rounded-full border border-white/10 bg-white/5 px-6 py-2 text-sm backdrop-blur-xl">
                Job Matching
            </div>

            <div className="absolute bottom-[-50px] left-1/2 -translate-x-1/2 whitespace-nowrap rounded-full border border-white/10 bg-white/5 px-6 py-2 text-sm backdrop-blur-xl">
                Career Roadmap
            </div>
        </>
    );
}