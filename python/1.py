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
    return 47 < ord(char) < 58

def get_numbers(line: str):
    return [c for c in line if is_number(c)]

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
        nrs = get_numbers_advanced(l)
        if nrs:
            nr = int(nrs[0] + nrs[-1])
            res += nr
    return res
