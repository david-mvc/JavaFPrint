
import java.lang.String;

class CC {
  public static final String RESET = "[0m";

  public static final char ESC = '\033';

  public static final String BLACK = "[0;30m";
  public static final String RED = "[0;31m";
  public static final String GREEN = "[0;32m";
  public static final String YELLOW = "[0;33m";
  public static final String BLUE = "[0;34m";
  public static final String PURPLE = "[0;35m";
  public static final String CYAN = "[0;36m";
  public static final String WHITE = "[0;37m";
  public static final String DEFAULT = "[0;39m";

  public static final String BOLD = "[1;37m";

  public static final String UNDERLINED = "[4;37m";


  public static final String BLACK(String s) {
      return makeColor(s, BLACK);
  }
  public static final String RED(String s) {
      return makeColor(s, RED);
  }
  public static final String GREEN(String s) {
      return makeColor(s, GREEN);
  }
  public static final String YELLOW(String s) {
      return makeColor(s, YELLOW);
  }
  public static final String BLUE(String s) {
      return makeColor(s, BLUE);
  }
  public static final String PURPLE(String s) {
      return makeColor(s, PURPLE);
  }
  public static final String CYAN(String s) {
      return makeColor(s, CYAN);
  }
  public static final String WHITE(String s) {
      return makeColor(s, WHITE);
  }

  public static final String BOLD(String s) {
      return makeBold(s);
  }

  public static final String UNDER(String s) {
      return makeUnderline(s);
  }

  private static final String makeColor(String s, String c) {
    if(s.charAt(0) == '\033') {
      s = setChar(s, 5, '7');
    } else {
      s = ESC + c + s + ESC + RESET;
    }
    return s;
  }

  private static final String makeBold(String s) {
    if(s.charAt(0) == '\033') {
      s = setChar(s, 2, '1');
    } else {
      s = ESC + BOLD + s + ESC + RESET;
    }
    return s;
  }

  private static final String makeUnderline(String s) {
    if(s.charAt(0) == '\033') {
      s = setChar(s, 2, '4');
    } else {
      s = ESC + UNDERLINED + s + ESC + RESET;
    }
    return s;
  }

  private static final String setChar(String s, int i, char c) {
    StringBuilder tmp = new StringBuilder(s);
    tmp.setCharAt(i, c);
    return tmp.toString();
}

}
