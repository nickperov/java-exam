package com.nickperov.study.ocp_1Z0_809.ch5_DatesStringsLocalization.locale;

import java.util.ListResourceBundle;

public class Zoo_en extends ListResourceBundle {

	@Override
	protected Object[][] getContents() {
		return new Object[][] {
			{"hello", "Hello"},
			{"open", "The zoo is open"}
		};
	}

}
