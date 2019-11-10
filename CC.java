
import java.lang.String;
import java.util.StringJoiner;
import java.util.Set;
import java.util.HashSet;

public class CC {

  enum COLOR {
    BLACK("0"),
    RED("1"),
    GREEN("2"),
    YELLOW("3"),
    BLUE("4"),
    PURPLE("5"),
    CYAN("6"),
    WHITE("7"),
    DEFAULT("9");

    private final String code;
    public String getCode() { return this.code; }
    private COLOR(String code) { this.code = code; }
  }

  enum EFFECT {
    RESET("0"),
    BOLD("1"),
    FAINT("2"),
    ITALIC("3"),
    UNDERLINE("4"),
    SLOW_BLINK("5"),
    FAST_BLINK("6"),
    INVERSE("7"),
    CONCEAL("8"),
    STRIKETHROUGH("9");

    private final String code;
    public String getCode() { return this.code; }
    private EFFECT(String code) { this.code = code; }
  }

  private COLOR foregroud_color;
  private COLOR backgroud_color;
  private Set<EFFECT> effects;

  private final char ESC = '\033';
  private final char FOREGROUD_COLOR = '3';
  private final char BACKGROUD_COLOR = '4';
  private final String START = "[";
  private final String END = "m";
  private final String SEPARATOR = ";";

  private CC(String s, COLOR color) {
    this.s = s;
    this.foregroud_color = color;
    this.backgroud_color = COLOR.DEFAULT;
    this.effects = new HashSet<>();
  }

  private String s;

  // ---------- Foregroud Colors ----------

  public static final CC BLACK(String s) {
      return new CC(s, COLOR.BLACK);
  }
  public static final CC RED(String s) {
      return new CC(s, COLOR.RED);
  }
  public static final CC GREEN(String s) {
      return new CC(s, COLOR.GREEN);
  }
  public static final CC YELLOW(String s) {
      return new CC(s, COLOR.YELLOW);
  }
  public static final CC BLUE(String s) {
      return new CC(s, COLOR.BLUE);
  }
  public static final CC PURPLE(String s) {
      return new CC(s, COLOR.PURPLE);
  }
  public static final CC CYAN(String s) {
      return new CC(s, COLOR.CYAN);
  }
  public static final CC WHITE(String s) {
      return new CC(s, COLOR.WHITE);
  }
  public static final CC DEFAULT(String s) {
      return new CC(s, COLOR.DEFAULT);
  }

  // ---------- Bakegroud Colors ----------

  public final CC BLACK_B() {
    return setBackgroudColor(COLOR.BLACK);
  }
  public final CC RED_B() {
      return setBackgroudColor(COLOR.RED);
  }
  public final CC GREEN_B() {
      return setBackgroudColor(COLOR.GREEN);
  }
  public final CC YELLOW_B() {
      return setBackgroudColor(COLOR.YELLOW);
  }
  public final CC BLUE_B() {
      return setBackgroudColor(COLOR.BLUE);
  }
  public final CC PURPLE_B() {
      return setBackgroudColor(COLOR.PURPLE);
  }
  public final CC CYAN_B() {
      return setBackgroudColor(COLOR.CYAN);
  }
  public final CC WHITE_B() {
      return setBackgroudColor(COLOR.WHITE);
  }
  public final CC DEFAULT_B() {
      return setBackgroudColor(COLOR.DEFAULT);
  }
  private final CC setBackgroudColor(COLOR c) {
    this.backgroud_color = c;
    return this;
  }

  // ---------- Effects ----------

  public final CC RESET() {
    effects.add(EFFECT.RESET);
    return this;
  }
  public final CC BOLD() {
    effects.add(EFFECT.BOLD);
    return this;
  }
  public final CC FAINT() {
    effects.add(EFFECT.FAINT);
    return this;
  }
  public final CC ITALIC() {
    effects.add(EFFECT.ITALIC);
    return this;
  }
  public final CC UNDERLINE() {
    effects.add(EFFECT.UNDERLINE);
    return this;
  }
  public final CC SLOW_BLINK() {
    effects.add(EFFECT.SLOW_BLINK);
    return this;
  }
  public final CC FAST_BLINK() {
    effects.add(EFFECT.FAST_BLINK);
    return this;
  }
  public final CC INVERSE() {
    effects.add(EFFECT.INVERSE);
    return this;
  }
  public final CC CONCEAL() {
    effects.add(EFFECT.CONCEAL);
    return this;
  }
  public final CC STRIKETHROUGH() {
    effects.add(EFFECT.STRIKETHROUGH);
    return this;
  }

  private String buildFormart() {
    StringBuilder sb = new StringBuilder();

    sb.append(ESC); // \033
    sb.append(START); // [

    sb.append(FOREGROUD_COLOR); // 3
    sb.append(this.foregroud_color.getCode()); //0
    sb.append(SEPARATOR); // ;

    sb.append(BACKGROUD_COLOR); // 4
    sb.append(this.backgroud_color.getCode()); //0


    if(this.effects.size() > 0) {
      sb.append(SEPARATOR); // ;
      StringJoiner join_effects = new StringJoiner(SEPARATOR);
      for(EFFECT f : effects) {
        join_effects.add(f.getCode());
      }
      sb.append(join_effects); // ; ;
    }

    sb.append(END); // m

    sb.append(this.s);

    // Reset Sequence
    sb.append(ESC);
    sb.append(START);
    sb.append(EFFECT.RESET.getCode());
    sb.append(END);

    String out = sb.toString();

    return sb.toString();
  }

  @Override
  public String toString() {
    return buildFormart();
  }

  private void printASCIcode(String s) {
    char[] cc = s.toCharArray();
    for(char c : cc) {
      System.out.println((int) c);
    }
  }

}
