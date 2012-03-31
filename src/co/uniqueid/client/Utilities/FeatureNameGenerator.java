package co.uniqueid.client.Utilities;

public class FeatureNameGenerator {

	/**
	 * Return the last name of a names sequence separated by dots already
	 * separated by spaces between the upper case letters.
	 */
	public static String getLastNameSpaced(String fullName, String splitChar) {

		return spacedName(getLastName(fullName, splitChar));
	}

	/**
	 * Return the last name of a names sequence separated by dots.
	 */
	public static String getLastName(String fullName, String splitChar) {

		String lastName = fullName;

		if (fullName != null) {

			String[] names = fullName.split(splitChar);

			if (names.length > 0) {

				lastName = names[names.length - 1];
			}
		}

		return lastName;
	}

	public static String getFileSpacedName(String fileName) {

		return spacedName(removeFileExtension(fileName));
	}

	/**
	 * Return the name of the file without its extension after the "."
	 */
	public static String removeFileExtension(String fileName) {

		String name = fileName;

		if (fileName != null) {

			String[] names = fileName.split("\\.");

			if (name.length() > 0) {

				name = names[0];
			}
		}

		return name;
	}

	/** Fill with spaces a name that is truncated. */
	public static String spacedName(String name) {

		String spacedName = name;

		if (name != null && name.length() > 0) {

			name = name.replaceAll("_", " ");
			String[] words = (name.substring(1)).split("[A-Z0-9]");
			if (words.length > 0) {
				spacedName = name.substring(0, 1).toUpperCase() + words[0];
				int wordPosition = spacedName.length();
				for (int i = 1; i < words.length; i++) {

					String firstLetter = name.substring(wordPosition,
							wordPosition + 1);
					firstLetter = firstLetter.toUpperCase();

					if (words[i - 1].length() > 1 || words[i].length() > 1) {

						spacedName += " ";
					}

					spacedName += firstLetter + words[i];

					wordPosition += (words[i].length() + 1);
				}

				if (wordPosition < name.length()) {

					spacedName += " " + name.substring(wordPosition);
				}

			} else {

				spacedName = name.toUpperCase();
			}
		}

		return spacedName;
	}
}
