import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 課題：読み込んだ整数値配列(A)に含まれない、最小の正の整数を求める
 * @author ky
 *
 */
class Solution {
	int tmp = 0;
	public int solution(int[] A) {
		IntStream a = IntStream.of(A).filter(value -> value > 0).sorted().distinct();
		a.forEach(i -> check(i));
		return tmp + 1;
	}
	void check(int i) {
		if (tmp + 1 < i)
			return;
		tmp = i;
	}

	// 以下は課題のScope外。
	public static void main(String[] args) {
		Path path = Paths.get("./test-input.txt");
		List<String> text;
		try {
			text = Files.lines(path, StandardCharsets.UTF_8).collect(Collectors.toList());
			String[] strings = text.get(0).split(",");
			int[] values = Stream.of(strings).map(String::trim).mapToInt(Integer::parseInt).toArray();
			Solution sol = new Solution();
			System.out.println(sol.solution(values));
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
}