NUMBERS = (
    ("one", "1"),
    ("two", "2"),
    ("three", "3"),
    ("four", "4"),
    ("five", "5"),
    ("six", "6"),
    ("seven", "7"),
    ("eight", "8"),
    ("nine", "9"),
)

def is_number(char: str):
    return ord("0") <= ord(char) <= ord("9")

def get_numbers_advanced(line: str):
    nrs = []
    while len(line):
        if is_number(line[0]):
            nrs.append(line[0])
        else:
            for token, nr in NUMBERS:
                if line.startswith(token):
                    nrs.append(nr)
                    break
        line = line[1:]
    return nrs

def process_lines(lines: str):
    res = 0
    for l in lines.split('\n'):
        # nrs = [c for c in l if is_number(c)]
        nrs = get_numbers(l)
        if nrs:
            nr = int(nrs[0] + nrs[-1])
            res += nr
    return res
