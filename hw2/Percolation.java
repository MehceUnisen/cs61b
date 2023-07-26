package hw2;

public class Percolation {
    int[][] data;
    int N;
    WeightedQuickUnionUF uf;

    public Percolation(int N) {
        this.N = N;
        data = new int[N][N];
        uf = new WeightedQuickUnionUF(N * N + 2);
        setSentinels();

    }

    public void open(int row, int col) {
        if (isOpen(row, col)) {
            data[row][col] = 1;
            if (row == 0) {
                data[row][col] = 2;
                rearrangeTiles(row, col);
            }
            checkSurroundings(row, col);

        } else {
            System.out.println("Location " + row + " - " + col + " is already open");
        }
    }

    public boolean isOpen(int row, int col) {
        if (data[row][col] == 0) {
            return true;
        }
        return false;
    }

    public boolean isFull(int row, int col) {
        return false;
    }

    public int numberOfOpenSites() {
        return 0;
    }

    public boolean percolates() {
        return false;
    }

    public int rowColToIndex(int row, int col) {
        return row * N + col;
    }

    public void checkSurroundings(int row, int col) {
        if (row > 0) {
            if (data[row - 1][col] == 2) {
                uf.union(rowColToIndex(row, col), rowColToIndex(row - 1, col));
                data[row][col] = 2;
                rearrangeTiles(row, col);
            } else if (data[row - 1][col] == 1) {
                uf.union(rowColToIndex(row, col), rowColToIndex(row - 1, col));
            }
        }
        if (row < N - 1) {
            if (data[row + 1][col] == 2) {
                uf.union(rowColToIndex(row, col), rowColToIndex(row + 1, col));
                data[row][col] = 2;
                rearrangeTiles(row, col);
            } else if (data[row + 1][col] == 1) {
                uf.union(rowColToIndex(row, col), rowColToIndex(row + 1, col));
            }
        }
        if (col < N - 1) {
            if (data[row][col + 1] == 2) {
                uf.union(rowColToIndex(row, col), rowColToIndex(row, col - 1));
                data[row][col] = 2;
                rearrangeTiles(row, col);
            } else if (data[row][col + 1] == 1) {
                uf.union(rowColToIndex(row, col), rowColToIndex(row, col - 1));
            }
        }
        if (col > 0) {
            if (data[row][col - 1] == 2) {
                uf.union(rowColToIndex(row, col), rowColToIndex(row, col - 1));
                data[row][col] = 2;
                rearrangeTiles(row, col);
            } else if (data[row][col - 1] == 1) {
                uf.union(rowColToIndex(row, col), rowColToIndex(row, col - 1));
            }
        }
    }

    public void rearrangeTiles(int row, int col) {
        if (row > 0) {
            if (data[row - 1][col] == 1) {
                data[row - 1][col] = 2;
            }
        }
        if (row < N - 1) {
            if (data[row + 1][col] == 1) {
                data[row + 1][col] = 2;
            }
        }
        if (col < N - 1) {
            if (data[row][col + 1] == 1) {
                data[row][col + 1] = 2;
            }
        }
        if (col > 0) {
            if (data[row][col - 1] == 1) {
                data[row][col - 1] = 2;
            }
        }
    }

    public void setSentinels() {
        for (int i = 1; i < N; i++) {
            uf.union(rowColToIndex(0, 0), rowColToIndex(0, i));
        }
        for (int i = 0; i < N; i++) {
            uf.union(26, rowColToIndex(N - 1, i));
        }
    }

    public static void main(String[] args) {
        Percolation x = new Percolation(5);
        x.open(0, 2);
        x.open(1, 2);
        x.open(3, 2);
        x.open(2, 2);
        x.open(2, 3);
        x.open(3, 3);
        x.open(4, 3);
        System.out.println(x.uf.connected(0, 26));
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(x.data[i][j] + " - ");
            }
            System.out.println();
        }
    }

}
