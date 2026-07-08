"use client";

import { motion } from "framer-motion";

export default function AIAgentOrb() {
  return (
    <div className="relative flex items-center justify-center">

      <motion.div
        animate={{
          scale: [1, 1.2, 1],
          opacity: [0.4, 0.8, 0.4],
        }}
        transition={{
          duration: 4,
          repeat: Infinity,
        }}
        className="absolute h-80 w-80 rounded-full bg-purple-500/20 blur-3xl"
      />

      <motion.div
        animate={{ rotate: 360 }}
        transition={{
          duration: 20,
          repeat: Infinity,
          ease: "linear",
        }}
        className="flex h-64 w-64 items-center justify-center rounded-full border border-purple-500/30 bg-white/5 backdrop-blur-xl"
      >
        <motion.div
          animate={{
            scale: [1, 1.1, 1],
          }}
          transition={{
            duration: 3,
            repeat: Infinity,
          }}
          className="h-32 w-32 rounded-full bg-gradient-to-br from-purple-500 via-violet-400 to-blue-500 shadow-2xl"
        />
      </motion.div>

    </div>
  );
}