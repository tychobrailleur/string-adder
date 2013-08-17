def notify(title, msg, img)
  system "notify-send --hint=int:transient:1 '#{title}' '#{msg}' -i #{img} -t 1000"
end

def match_testing(output)
  image_root = "~/.autotest_images"
  if output =~ /FAIL/
    notify "FAIL", "#{output}", "#{image_root}/fail.png"
  else
    notify "Pass", "#{output}", "#{image_root}/pass.png"
  end
end

def test_stuff
  match_testing(`lein test`)
end

watch('test/.*\.clj') { |md| test_stuff }
watch('src/.*\.clj') { |md| test_stuff }
