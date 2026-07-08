"use client";

type ATSGaugeProps = {
  score: number;
};

export default function ATSGauge({
  score,
}: ATSGaugeProps) {

  const radius = 70;
  const circumference = 2 * Math.PI * radius;

  const offset =
    circumference -
    (score / 100) * circumference;

  return (
    <div className="flex flex-col items-center justify-center">

      <div className="relative">

        <svg
          width="180"
          height="180"
          className="-rotate-90"
        >
          <circle
            cx="90"
            cy="90"
            r={radius}
            stroke="rgba(255,255,255,0.1)"
            strokeWidth="12"
            fill="transparent"
          />

          <circle
            cx="90"
            cy="90"
            r={radius}
            stroke="url(#gradient)"
            strokeWidth="12"
            fill="transparent"
            strokeDasharray={circumference}
            strokeDashoffset={offset}
            strokeLinecap="round"
          />

          <defs>
            <linearGradient
              id="gradient"
              x1="0%"
              y1="0%"
              x2="100%"
              y2="100%"
            >
              <stop
                offset="0%"
                stopColor="#8b5cf6"
              />
              <stop
                offset="100%"
                stopColor="#3b82f6"
              />
            </linearGradient>
          </defs>
        </svg>

        <div className="absolute inset-0 flex flex-col items-center justify-center">
          <p className="text-4xl font-bold">
            {score}%
          </p>

          <p className="text-sm text-slate-400">
            ATS Score
          </p>
        </div>

      </div>

    </div>
  );
}