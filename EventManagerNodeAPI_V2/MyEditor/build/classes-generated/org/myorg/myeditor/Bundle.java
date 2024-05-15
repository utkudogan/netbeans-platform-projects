package org.myorg.myeditor;
/** Localizable strings for {@link org.myorg.myeditor}. */
class Bundle {
    /**
     * @return <i>Open Editor</i>
     * @see MyEditor
     */
    static String CTL_MyEditorAction() {
        return org.openide.util.NbBundle.getMessage(Bundle.class, "CTL_MyEditorAction");
    }
    /**
     * @return <i>Open Editor Singleton</i>
     * @see MyEditorSingleton
     */
    static String CTL_MyEditorSingletonAction() {
        return org.openide.util.NbBundle.getMessage(Bundle.class, "CTL_MyEditorSingletonAction");
    }
    private Bundle() {}
}
