package africa.semicolon.data.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@NoArgsConstructor
@Data
public class Contact {

    private int id;
    @NonNull
    private String phoneNumber;

    @NonNull
    private String firstName;

    @NonNull
    private String lastName;


}
