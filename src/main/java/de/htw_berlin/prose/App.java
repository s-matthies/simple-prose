/*
 * Copyright (C) 2025 Sabine Matthies
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <https://www.gnu.org/licenses/>.
 *
 * SPDX-License-Identifier: GPL-3.0-or-later
 */

package de.htw_berlin.prose;

import de.htw_berlin.fb4.ossd.prose.ProseBuilder;

import java.util.List;

public class App {
    public static void main(String[] args) {

        SimpleWeatherSentence berlinWeather = new SimpleWeatherSentence();  // Berlin ist Standard
        SimpleWeatherSentence bangkokWeather = new SimpleWeatherSentence("Bangkok");
        SimpleWeatherSentence pragWeather = new SimpleWeatherSentence("Prag");

        // with SimpleProse
        SimpleProse simpleProse = new SimpleProse(List.of(berlinWeather, bangkokWeather, pragWeather
        ));

        System.out.println("=== Output with SimpleProse ===");
        System.out.println(simpleProse.getText());
        System.out.println();

        // with ProseBuilder
        ProseBuilder builder = new ProseBuilder();
        builder.register(berlinWeather);
        builder.register(bangkokWeather);
        builder.register(pragWeather);

        System.out.println("=== Output with ProseBuilder ===");
        System.out.println(builder.get());
    }
}