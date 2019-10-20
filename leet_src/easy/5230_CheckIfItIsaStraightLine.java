class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        if (coordinates.length == 2) {
            return true;
        }

        int x1 = coordinates[0][0];
        int y1 = coordinates[0][1];

        int x2 = coordinates[1][0];
        int y2 = coordinates[1][1];

        int a = y2 - y1;
        int b = x1 - x2;
        int c = -a * x1 - b * y1;

        for (int i = 2; i < coordinates.length; i ++) {
            int tmpX = coordinates[i][0];
            int tmpY = coordinates[i][1];
            if (a * tmpX + b * tmpY + c != 0) {
                return false;
            }
        }
        return true;
    }
}
