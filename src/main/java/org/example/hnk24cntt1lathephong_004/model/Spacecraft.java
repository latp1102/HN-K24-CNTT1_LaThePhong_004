package org.example.hnk24cntt1lathephong_004.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "spacecraft")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Spacecraft {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Tên không được để trống")
    @Size(min = 5, max = 150, message = "Tên phải từ 5 đến 150 ký tự")
    @Column(name = "name")
    private String name;
    @NotBlank(message = "Nhà sản xuất không được để trống")
    @Column(name = "manufacturer")
    private String manufacturer;
    @NotNull(message = "Ngày không được để trống")
    @PastOrPresent(message = "Ngày không hợp lệ")
    @Column(name = "date")
    private LocalDate date;
}
