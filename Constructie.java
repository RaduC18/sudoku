public class Constructie {

 int[][] matrice;

  public int[][] getMatrice() {

    return matrice;

  }

  public void setMatrice(int[][] NewMatrice) {
    this.matrice = NewMatrice;

  }

  public static boolean Isvalid(int rand, int coloana, int[][] array, int n) {

    for (int i = 0; i < 9; i++) {
      if (array[rand][i] == n || array[i][coloana] == n) {
        return false;
      }
    }
    int subRand = rand - rand % 3;
    int subColoana = coloana - coloana % 3;
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (array[subRand + i][subColoana + j] == n) {
          return false;
        }
      }
    }
    return true;
  }

  public static int random(int random) {

    return (int) (Math.random() * random);
  }

  public void Matrice() {
    int i;
    int j;
    int[][] array = new int[9][9];
    for (i = 0; i < 9; i++) {
      for (j = 0; j < 9; j++)
        array[i][j] = 0;
    }
    int b = 0;
    while (b < 25) {
      int coloana = random(9);
      int rand = random(9);
      int a = random(9) + 1;
      if (array[rand][coloana] == 0)

      {
        if (Isvalid(rand, coloana, array, a)) {

          array[rand][coloana] = a;
          b++;

        }

      }
    }

    setMatrice(array);

  }

}