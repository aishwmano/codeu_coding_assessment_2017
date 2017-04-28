// Copyright 2017 Google Inc.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//    http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.



import java.util.*;

final class MyJSON implements JSON {
	private Map<String, String> stringValues;
	private Map<String, JSON> objectValues;

	public MyJSON() {
		stringValues = new HashMap<String, String>();
		objectValues = new HashMap<String, JSON>();
	}
	@Override
	public JSON getObject(String name) {
		if(objectValues.containsKey(name)) {
			return objectValues.get(name);
		}
		return null;
	}

	@Override
	public JSON setObject(String name, JSON value) {
		if(objectValues.containsKey(name)) {
			objectValues.replace(name, value);
		} else {
			objectValues.put(name, value);
		}
		return this;
	}

	@Override
	public String getString(String name) {
		if(stringValues.containsKey(name)) {
			return stringValues.get(name);
		}
		return null;
	}

	@Override
	public JSON setString(String name, String value) {
		if(stringValues.containsKey(name)) {
			stringValues.replace(name, value);
		} else {
			stringValues.put(name, value);
		}
		return this;
	}

	@Override
	public void getObjects(Collection<String> names) {
		names = objectValues.keySet();
	}

	@Override
	public void getStrings(Collection<String> names) {
		names = stringValues.keySet();
	}
}
