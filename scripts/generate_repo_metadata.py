import os
import json

ROOT_DIR = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))
# ROOT_DIR = os.getcwd()
DOCS_PATTERN_PATH = os.path.join(ROOT_DIR, 'docs', 'tech_credit_patterns.json')
OUTPUT_PATH = os.path.join(ROOT_DIR, 'repo_metadata.json')

# Load pattern definitions
with open(DOCS_PATTERN_PATH, 'r', encoding='utf-8') as f:
    print("Reading ", DOCS_PATTERN_PATH)
    patterns = json.load(f)

pattern_dict = {p["pattern_name"]: p["pattern_description"] for p in patterns}

# Collect all metadata entries
final_metadata = []
for dirpath, _, filenames in os.walk(ROOT_DIR):
    if 'repo_metadata.json' in filenames and dirpath != ROOT_DIR:
        metadata_path = os.path.join(dirpath, 'repo_metadata.json')
        print("Reading ", metadata_path)
        with open(metadata_path, 'r', encoding='utf-8') as f:
            entries = json.load(f)
        for entry in entries:
            abs_path = os.path.normpath(os.path.join(dirpath, entry["path"]))
            rel_path = os.path.relpath(abs_path, ROOT_DIR).replace('\\', '/')
            tech_credit = entry.get("tech-credit", "")
            final_metadata.append({
                "path": rel_path,
                "type": entry.get("type", ""),
                "tech_credit": tech_credit,
                "tech_credit_description": pattern_dict.get(tech_credit, "")
            })

# Write to root-level repo_metadata.json
with open(OUTPUT_PATH, 'w', encoding='utf-8') as f:
    json.dump(final_metadata, f, indent=2, ensure_ascii=False)
