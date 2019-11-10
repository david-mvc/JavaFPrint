


public class Main {

  public static void main(String[] args) {

    System.out.println(CC.BLUE("HELLO") + " WORLD");

    System.out.println(CC.BLACK("HELLO").BOLD() + " WORLD");

    System.out.println(CC.RED("HELLO").UNDERLINE().FAINT() + " WORLD");

    System.out.println(CC.CYAN("HELLO").WHITE_B() + " WORLD");

    System.out.println(CC.PURPLE("HELLO").STRIKETHROUGH() + " WORLD");

    System.out.println(CC.YELLOW("HELLO").ITALIC() + " WORLD");

    System.out.println(CC.GREEN("HELLO").BLACK_B().SLOW_BLINK() + " WORLD");
  }

}
