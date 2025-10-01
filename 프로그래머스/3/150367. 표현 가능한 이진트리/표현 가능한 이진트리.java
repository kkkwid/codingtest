class Solution {

    public int[] solution(long[] numbers) {
        int N = numbers.length;
        int[] ans = new int[N];

        for (int i = 0; i < N; i++) {
            ans[i] = solve(numbers[i]);
        }

        return ans;
    }

    private static int solve(long number) {
        String input = Long.toBinaryString(number);

        int treeSize = 2;
        while (treeSize <= input.length()) {
            treeSize <<= 1;
        }
        treeSize--;

        StringBuilder dummy = new StringBuilder();
        for (int i = input.length(); i < treeSize; i++) {
            dummy.append("0");
        }

        char[] tree = (dummy.append(input).toString()).toCharArray();

        int cnt = dfs(tree, tree.length / 2, tree.length / 2);
        return cnt == Long.bitCount(number) ? 1 : 0;
    }

    private static int dfs(char[] tree, int subTreeSize, int node) {
        if (tree[node] == '0') return 0;
        if (subTreeSize == 0) return tree[node] == '1' ? 1 : 0;

        int cnt = 1;

        cnt += dfs(tree, subTreeSize / 2, node - (subTreeSize + 1) / 2);
        cnt += dfs(tree, subTreeSize / 2, node + (subTreeSize + 1) / 2);

        return cnt;
    }

}