package cn.intersteller.darkintersteller.login.view;

public interface ILoginView {
	void onClearText();
	void onLoginResult(Boolean result, int returncode, long userid);
	void onSetProgressBarVisibility(int visibility);
}
