public enum VrstaCveca {
    RUZA,
    TULIPAN,
    LJILJAN,
    ORHIDEJA,
    SUNCOKRET,
    ZUMBUL,
    GERBER,;

    public static String getVrstaCveca(VrstaCveca vrstaCveca) {
        switch (vrstaCveca) {
            case RUZA:
                return "Ruza";
            case TULIPAN:
                return "Tulipan";
            case LJILJAN:
                return "Ljiljan";
            case ORHIDEJA:
                return "Orhideja";
            case SUNCOKRET:
                return "Suncokret";
            case ZUMBUL:
                return "Zumbul";
            case GERBER:
                return "Gerber";
            default:
                return null;
        }
    }

}
