package travelator.mobile;

import java.util.Currency;
import java.util.Locale;

public class PreferencesView extends View {

    private final UserPreferences preferences;
    private final GreetingPicker greetingPicker = new GreetingPicker();
    private final LocalePicker localePicker = new LocalePicker();
    private final CurrencyPicker currencyPicker = new CurrencyPicker();

    public PreferencesView(UserPreferences preferences) {
        this.preferences = preferences;
    }

    public void show() {
        greetingPicker.setGreeting(preferences.greeting);
        localePicker.setLocale(preferences.locale);
        currencyPicker.setCurrency(preferences.currency);
        super.show();
    }

    protected void onGreetingChange() {
        preferences.greeting = greetingPicker.getGreeting();
    }

    protected void onLocaleChange() {
        preferences.locale = localePicker.getLocale();
    }

    protected void onCurrencyChange() {
        preferences.currency = currencyPicker.getCurrency();
    }
}

class GreetingPicker {
    private String greeting;

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }
}

class LocalePicker {
    private Locale locale;

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }
}

class CurrencyPicker {
    private Currency currency;

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }
}