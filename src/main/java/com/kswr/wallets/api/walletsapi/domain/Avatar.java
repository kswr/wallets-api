package com.kswr.wallets.api.walletsapi.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Avatar extends AbstractPersistableEntity<Long>{

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToOne(mappedBy = "avatar")
    private User user;

    @Column
    private String fileName;

    @Column
    private String fileType;

    @Lob
    private byte[] picture;
}
