package org.word.editor.history;
/** Localizable strings for {@link org.word.editor.history}. */
class Bundle {
    /**
     * @return <i>WordHistory</i>
     * @see WordHistoryTopComponent
     */
    static String CTL_WordHistoryAction() {
        return org.openide.util.NbBundle.getMessage(Bundle.class, "CTL_WordHistoryAction");
    }
    /**
     * @return <i>WordHistory Window</i>
     * @see WordHistoryTopComponent
     */
    static String CTL_WordHistoryTopComponent() {
        return org.openide.util.NbBundle.getMessage(Bundle.class, "CTL_WordHistoryTopComponent");
    }
    /**
     * @return <i>This is a WordHistory window</i>
     * @see WordHistoryTopComponent
     */
    static String HINT_WordHistoryTopComponent() {
        return org.openide.util.NbBundle.getMessage(Bundle.class, "HINT_WordHistoryTopComponent");
    }
    private Bundle() {}
}
