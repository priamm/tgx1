function(Prefix list prefix)
  string(REGEX REPLACE "([^;]+)" "${prefix}\\1" newList "${${list}}")
  set(${list} "${newList}" PARENT_SCOPE)
endfunction(Prefix)

function(Transform list regex replacement)
  set(newList "")
  foreach(line ${${list}})
    string(REGEX REPLACE "${regex}" "${replacement}" newLine "${line}")
    list(APPEND newList "${newLine}")
  endforeach()
  set(${list} "${newList}" PARENT_SCOPE)
endfunction(Transform)