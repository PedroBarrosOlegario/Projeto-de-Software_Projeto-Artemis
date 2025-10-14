export function Logo({ className = '' }: { className?: string }) {
  return (
    <div className={`flex items-center justify-center ${className}`}>
      <div className="text-4xl font-bold text-slate-700">
        <span className="text-slate-600">ARTEMIS</span>
      </div>
    </div>
  );
}
