package br.com.shapeup.backoffice.domain.enuns;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum CategoryEnum {
    AEROBIC("AEROBIC"),
    STRENGTH("STRENGTH"),
    HEALTH("HEALTH"),
    FIGHT("FIGHT");

    private final String category;

    public static CategoryEnum toEnum(String category) {
        for(CategoryEnum categoryEnum : CategoryEnum.values()) {
            if(categoryEnum.getCategory().equalsIgnoreCase(category))
                return categoryEnum;
        }

        return null;
    }
}



